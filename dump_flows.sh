#!/bin/bash

set -ux

SW=${1}

sudo ovs-ofctl dump-flows ${SW}
