ovs-ofctl add-flow s1 priority=100,in_port=2,tcp_dst=100,tcp_src=4500,dl_type='0x0800',ip_proto='0x06',ip_src=10.10.0.1,ip_dst=10.10.0.5,actions=1
ovs-ofctl add-flow s1 priority=300,in_port=2,tcp_dst=100,tcp_src=4500,dl_type='0x0800',ip_proto='0x06',ip_src=10.10.0.1,ip_dst=10.10.0.5,actions=2
ovs-ofctl add-flow s1 priority=400,in_port=2,tcp_dst=100,tcp_src=4500,dl_type='0x0800',ip_proto='0x06',ip_src=10.10.0.1,ip_dst=10.10.0.5,actions=3
ovs-ofctl add-flow s1 priority=401,in_port=2,tcp_dst=100,tcp_src=4500,dl_type='0x0800',ip_proto='0x06',ip_src=10.10.0.1,ip_dst=10.10.0.5,actions=4
ovs-ofctl add-flow s1 priority=100,in_port=2,udp_dst=105,udp_src=4200,dl_type='0x0800',ip_proto='0x06',ip_src=10.10.0.2,ip_dst=10.10.0.5,actions=40
ovs-ofctl add-flow s1 priority=200,in_port=2,udp_dst=105,udp_src=4200,dl_type='0x0800',ip_proto='0x06',ip_src=10.10.0.2,ip_dst=10.10.0.5,actions=50
