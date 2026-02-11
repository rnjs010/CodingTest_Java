import java.util.*;

class Solution {
    static class Work {
        String name;
        int start;
        int remain;

        Work(String name, int start, int remain) {
            this.name = name;
            this.start = start;
            this.remain = remain;
        }
    }

    public String[] solution(String[][] plans) {
        List<Work> list = new ArrayList<>();
        for (String[] p : plans) {
            String[] t = p[1].split(":");
            int start = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            int time = Integer.parseInt(p[2]);
            list.add(new Work(p[0], start, time));
        }

        list.sort(Comparator.comparingInt(w -> w.start));

        Stack<Work> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        int currentTime;

        for (int i = 0; i < list.size(); i++) {
            Work current = list.get(i);
            currentTime = current.start;

            int nextStart = (i + 1 < list.size()) ? list.get(i + 1).start : Integer.MAX_VALUE;
            int availableTime = nextStart - currentTime;

            if (current.remain <= availableTime) {
                result.add(current.name);
                int freeTime = availableTime - current.remain;

                while (!stack.isEmpty() && freeTime > 0) {
                    Work prev = stack.pop();
                    if (prev.remain <= freeTime) {
                        freeTime -= prev.remain;
                        result.add(prev.name);
                    } else {
                        prev.remain -= freeTime;
                        stack.push(prev);
                        freeTime = 0;
                    }
                }

            } else {
                current.remain -= availableTime;
                stack.push(current);
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop().name);
        }

        return result.toArray(new String[0]);
    }
}