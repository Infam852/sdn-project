#!/usr/bin/python

from mininet.topo import Topo


#class SdnTopo(Topo):
#    def __init__(self):
#        Topo.__init__(self)
#
#        SW_ACC_NUM = 3
#        SW_AGG_NUM = 2
#        sws = []
#
#        for k in range(SW_ACC_NUM):
#            sws.append(self.addSwitch("swac{}".format(k)))
#
#        for k in range(SW_ACC_NUM):
#            sws.append(self.addSwitch("swag{}".format(k)))
#        
##        sws.append(self.addSwitch("swc1"))
#        hosts = [self.addHost("h{}".format(n)) for n in range(SW_ACC_NUM)]
#        
#        acc_sws = list(filter(lambda sw: "swac" in sw, sws))
#        for sw, host in zip(acc_sws, hosts):
#            self.addLink(sw, host)
#
#        agg_sws = list(filter(lambda sw: "swag" in sw, sws))
#        for swa in acc_sws:
#            for swg in agg_sws:
#                self.addLink(swa, swg)
#
#        for sw in agg_sws:
#            self.addLink(sw, "swc1")

def int2dpid(dpid):
    try:
        dpid = hex(dpid)[2:]
        dpid = '0' * (16 - len(dpid)) + dpid
        return dpid
    except IndexError:
        raise Exception('Unable to derive default dpid')


class SdnTopo(Topo):
    def __init__(self):
        Topo.__init__(self)

        h0 = self.addHost("h0")
        h1 = self.addHost("h1")
        h2 = self.addHost("h2")

        swac0 = self.addSwitch("swac0", dpid=int2dpid(1))
        swac1 = self.addSwitch("swac1", dpid=int2dpid(2))
        swac2 = self.addSwitch("swac2", dpid=int2dpid(3))

        swag0 = self.addSwitch("swag0", dpid=int2dpid(11))
        swag1 = self.addSwitch("swag1", dpid=int2dpid(12))

        swc0 = self.addSwitch("sc0", dpid=int2dpid(21))

        self.addLink(h0, swac0)
        self.addLink(h1, swac1)
        self.addLink(h2, swac2)

        self.addLink(swac0, swag0)
        self.addLink(swac0, swag1)
        self.addLink(swac1, swag0)
        self.addLink(swac1, swag1)
        self.addLink(swac2, swag0)
        self.addLink(swac2, swag1)

        self.addLink(swag0, swc0)
        self.addLink(swag1, swc0)



topos = { 'sdn-topo': ( lambda: SdnTopo() ) }
