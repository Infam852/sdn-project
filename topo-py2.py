#!/usr/bin/python

from mininet.topo import Topo


class SdnTopo(Topo):
    def __init__(self):
        Topo.__init__(self)

        SW_ACC_NUM = 3
        SW_AGG_NUM = 2
        sws = []

        for k in range(SW_ACC_NUM):
            sws.append(self.addSwitch("swac{}".format(k)))

        for k in range(SW_ACC_NUM):
            sws.append(self.addSwitch("swag{}".format(k)))
        
        sws.append(self.addSwitch("swc1"))
        hosts = [self.addHost("h{}".format(n)) for n in range(SW_ACC_NUM)]
        
        acc_sws = list(filter(lambda sw: "swac" in sw, sws))
        for sw, host in zip(acc_sws, hosts):
            self.addLink(sw, host)

        agg_sws = list(filter(lambda sw: "swag" in sw, sws))
        for swa in acc_sws:
            for swg in agg_sws:
                self.addLink(swa, swg)

        for sw in agg_sws:
            self.addLink(sw, "swc1")


topos = { 'sdn-topo': ( lambda: SdnTopo() ) }
