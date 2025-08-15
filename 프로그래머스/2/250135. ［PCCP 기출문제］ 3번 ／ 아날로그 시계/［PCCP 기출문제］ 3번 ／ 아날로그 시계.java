class Solution {
    double curHd, curMd, curSd;
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int ans = 0;
        int start = h1*3600 + m1*60 + s1;
        int end = h2*3600 + m2*60 + s2;
        
        calDegree(h1, m1, s1);
        while(start < end) {
            start++;
            ans += nextD();
        }
        
        calDegree(h1, m1, s1);
        if (Double.compare(curHd, curMd) == 0 || Double.compare(curMd, curSd) == 0) ans++;
        calDegree(h2, m2, s2);
        if (Double.compare(curHd, curMd) == 0 || Double.compare(curMd, curSd) == 0) ans++;
        
        return ans;
    }
    
    public void calDegree(int h, int m, int s) {
        this.curHd = (h % 12)*30 + m*(0.5) + s*((double) 1/120);
        this.curMd = (m*6) + (s*0.1);
        this.curSd = s*6;
    }
    
    public int nextD() {
        int cnt = 0;
        double prevH = this.curHd;
        double prevM = this.curMd;
        double prevS = this.curSd;
        
        this.curHd += ((double) 1/120);
        this.curMd += 0.1;
        this.curSd += 6;
        
        if(Double.compare(prevH, prevS) > 0 && Double.compare(curHd,curSd) <= 0) cnt++;
        if(Double.compare(prevM, prevS) > 0 && Double.compare(curMd,curSd) <= 0) cnt++;
        if((Double.compare(prevH, prevM) > 0 && Double.compare(prevH,prevS) > 0) 
           && (Double.compare(curHd, curMd) <= 0 && Double.compare(curHd, curSd) <= 0)) cnt--;

        if(this.curHd >=360) this.curHd %= 360; 
        if(this.curMd >=360) this.curMd %= 360;
        if(this.curSd >=360) this.curSd %= 360;
        return cnt;
    }
}