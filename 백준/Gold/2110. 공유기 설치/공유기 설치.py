import sys
input = sys.stdin.readline
n, c = map(int, input().split())
li = sorted([int(input()) for _ in range(n)])

l, r = 1, li[-1] - li[0]
ans = 0
while l <= r:
    mid = (l + r) // 2
    cur = li[0]
    cnt = 1
    for i in range(1, n):
        if li[i] >= cur + mid:
            cnt += 1
            cur = li[i]
    
    if cnt >= c:
        l = mid + 1
        ans = mid
    else:
        r = mid - 1

print(ans)