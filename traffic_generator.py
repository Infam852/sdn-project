from numpy.random import exponential as exp
import os
import time
import random


def generator(elephant_duration_lambda=20, elephant_bandwidth_lambda=20, non_elephant_duration_lambda=1,
              non_elephant_bandwidth_lambda=0.1, time_between_flows_lambda=0.2, port_min=61001, port_max=64000,
              ip_dest='10.0.0.2'):
    while True:
        elephant = True if random.randint(1, 20) == 1 else False

        if elephant:
            flow_duration = round(exp(scale=elephant_duration_lambda), 2)
            bandwidth = round(1024 ** 2 * exp(scale=elephant_bandwidth_lambda))  # Mb/s
        else:
            flow_duration = round(exp(scale=non_elephant_duration_lambda), 2)
            bandwidth = round(1024 ** 2 * exp(scale=non_elephant_bandwidth_lambda))  # Mb/s
        
        bandwidth = max(bandwidth, 12000)

        time_to_next_flow = round(exp(scale=time_between_flows_lambda), 3)  # s

        port = random.randint(port_min, port_max)

        time.sleep(time_to_next_flow)
        command = "iperf -c {} -u -b {} -t {} -p {} &".format(ip_dest, bandwidth, flow_duration, port)
        print '------------------------------------------------------------'
        print "Executing command: "
        print command
        print '------------------------------------------------------------'
        os.system(command)


if __name__ == '__main__':
    generator()
