class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack=new ArrayDeque<>();
        for(int a:asteroids)
        {
            if(stack.isEmpty())
            {
                stack.push(a);
                continue;
            }
            if(a<0&&stack.peek()>0)
            {
                while(!stack.isEmpty()&&Math.abs(a)>Math.abs(stack.peek())&&stack.peek()>0)
                {
                    stack.pop();
                }
                if(stack.isEmpty()||stack.peek()<0)
                    stack.push(a);
                else if(stack.peek()>0&&Math.abs(stack.peek())==Math.abs(a))
                    stack.pop();
            }
            else
            {
                stack.push(a);
            }
        }
        int[] res=new int[stack.size()];
        for(int i=res.length-1;i>=0;i--)
        {
            res[i]=stack.pop();
        }
        return res;        
    }
}