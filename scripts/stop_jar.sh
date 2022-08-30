#!/bin/bash
# Shutdown Server Script

kill -9 $(ps aux |awk '/papercpnPro/ {print $2}')