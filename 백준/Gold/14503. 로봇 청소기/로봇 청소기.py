import sys
input = sys.stdin.readline

n, m = map(int, input().split())
r, c, d = map(int, input().split())
li = [[*map(int, input().split())] for _ in range(n)]

dr, dc = [-1, 0, 1, 0], [0, 1, 0, -1]
cnt = 0
while True:
    if li[r][c] == 0:
        cnt += 1
        li[r][c] = 2
    
    for i in range(4):
        if li[r + dr[i]][c + dc[i]] == 0:
            break
    else:
        r += dr[(d + 2) % 4]
        c += dc[(d + 2) % 4]
        if li[r][c] == 1:
            break
        else:
            continue
    
    for i in range(4):
        d -= 1
        if d < 0: d = 3
        if li[r + dr[d]][c + dc[d]] == 0:
            r += dr[d]
            c += dc[d]
            break

print(cnt)