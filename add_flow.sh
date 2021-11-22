#!/bin/bash

set -ux

SW=${1}
IN_PORT=${2}
OUT_PORT=${3}

sudo ovs-ofctl add-flow ${SW} in_port=${SW}-${IN_PORT},actions=output:${SW}-${OUT_PORT}
