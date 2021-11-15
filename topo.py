from mininet.topo import Topo
from mininet.net import Mininet
from mininet.cli import CLI


class MyTopo(Topo):
    def __init__(self):
        Topo.__init__(self)

        SW_ACC_NUM = 3
        SW_AGG_NUM = 2

        sws = [
            *[self.addSwitch(f"swac{n}") for n in range(SW_ACC_NUM)],
            *[self.addSwitch(f"swag{n}") for n in range(SW_AGG_NUM)],
            self.addSwitch("swc1")
        ]

        hosts = [self.addHost(f"h{n}") for n in range(SW_ACC_NUM)]

        acc_sws = list(filter(lambda sw: "swac" in sw, sws))
        for sw, host in zip(acc_sws, hosts):
            self.addLink(sw, host)

        agg_sws = list(filter(lambda sw: "swag" in sw, sws))
        for swa in acc_sws:
            for swg in agg_sws:
                self.addLink(swa, swg)

        for sw in agg_sws:
            self.addLink(sw, "swc1")


def disable_ipv6(net):
    for h in net.hosts:
        h.cmd("sysctl -w net.ipv6.conf.all.disable_ipv6=1")
        h.cmd("sysctl -w net.ipv6.conf.default.disable_ipv6=1")
        h.cmd("sysctl -w net.ipv6.conf.lo.disable_ipv6=1")

    for sw in net.switches:
        sw.cmd("sysctl -w net.ipv6.conf.all.disable_ipv6=1")
        sw.cmd("sysctl -w net.ipv6.conf.default.disable_ipv6=1")
        sw.cmd("sysctl -w net.ipv6.conf.lo.disable_ipv6=1")


if __name__ == "__main__":
    topo = MyTopo()
    net = Mininet(topo=topo, waitConnected=True)
    disable_ipv6(net)

    net.start()
    CLI( net )
    net.stop()
