sudo ovs-ofctl add-flow swac0 in_port=swac0-eth1,actions=output:swac0-eth2
sudo ovs-ofctl add-flow swag0 in_port=swag0-eth1,actions=output:swag0-eth2
sudo ovs-ofctl add-flow swac1 in_port=swac1-eth2,actions=output:swac1-eth1

sudo ovs-ofctl add-flow swac1 in_port=swac1-eth1,actions=output:swac1-eth2
sudo ovs-ofctl add-flow swag0 in_port=swag0-eth2,actions=output:swag0-eth1
sudo ovs-ofctl add-flow swac0 in_port=swac0-eth2,actions=output:swac0-eth1
