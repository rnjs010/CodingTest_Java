n = int(input())
num_li = list(map(int, input().split()))
op = list(map(int, input().split()))

maximum = -1e9
minimum = 1e9

def dfs(depth, total, plus, minus, mul, div):
    global maximum, minimum
    if depth == n:
        maximum = max(total, maximum)
        minimum = min(total, minimum)
        return
    
    if plus:
        dfs(depth + 1, total + num_li[depth], plus - 1, minus, mul, div)
    if minus:
        dfs(depth + 1, total - num_li[depth], plus, minus - 1, mul, div)
    if mul:
        dfs(depth + 1, total * num_li[depth], plus, minus, mul - 1, div)
    if div:
        dfs(depth + 1, int(total / num_li[depth]), plus, minus, mul, div - 1)

dfs(1, num_li[0], op[0], op[1], op[2], op[3])
print(maximum)
print(minimum)