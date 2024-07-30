import sys
input = sys.stdin.readline
from itertools import combinations
n, m = map(int, input().split())
board = [[*map(int, input().split())] for _ in range(n)]

shop, home = [], []
for i in range(n):
    for j in range(n):
        if board[i][j] == 2:
            shop.append((i, j))
        if board[i][j] == 1:
            home.append((i, j))

all = []
comb = combinations(shop, m)
for s in comb:
    dist = 0
    for i in home:
        min_d = 101
        for j in s:
            min_d = min(min_d, abs(i[0] - j[0]) + abs(i[1] - j[1]))
        dist += min_d
    all.append(dist)

print(min(all))