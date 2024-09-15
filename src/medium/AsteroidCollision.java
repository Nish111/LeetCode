package medium;

import java.util.Stack;

public class AsteroidCollision {
//  https://leetcode.com/problems/asteroid-collision/?envType=study-plan-v2&envId=leetcode-75
	public int[] asteroidCollisionBest(int[] asteroids) { // check again
        int i=0, pos=1, n = asteroids.length;
        for(i=1;i<n;i++){
            while(pos>=0){
                if(pos == 0){
                    asteroids[0] = asteroids[i];
                    pos = 1;
                    break;
                } else if(asteroids[pos-1]>0){
                    if(asteroids[i]>0){
                        asteroids[pos++] = asteroids[i];
                        break;
                    } else if(asteroids[pos-1] == -1 * asteroids[i]){
                        pos--;
                        break;
                    }else{
                        if(asteroids[pos-1] < -1 * asteroids[i]){
                            pos--;
                        } else{
                            break;
                        }
                    }
                } else{
                    asteroids[pos++] = asteroids[i];
                    break;
                }
                
            }
        }
        int[] result = new int[pos];
        for(i=0;i<pos;i++){
            result[i] = asteroids[i];
        }
        return result;
    }
	public int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> store = new Stack<>();
		for (int i : asteroids) {
			if (i > 0)
				store.push(i);
			else {
				// remove all the positive elements in stack less than current
				while (!store.isEmpty() && store.peek() > 0 && store.peek() < -i) {
					store.pop();
				}
				// if stack empty or has negative then add current negatives
				if (store.isEmpty() || store.peek() < 0) {
					store.push(i);
				}
				// is same then remove
				if (store.peek() == -i)
					store.pop();
			}
		}
		// store back in array
		int[] res = new int[store.size()];
		int i = store.size() - 1;

		while (!store.isEmpty()) {
			res[i--] = store.pop();
		}

		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AsteroidCollision ac = new AsteroidCollision();
		int[] a = { 5, 10, -5 };
		int[] b = ac.asteroidCollision(a);
		/*
		 * Example 1:
		 * 
		 * Input: asteroids = [5,10,-5] Output: [5,10] Explanation: The 10 and -5
		 * collide resulting in 10. The 5 and 10 never collide. Example 2:
		 * 
		 * Input: asteroids = [8,-8] Output: [] Explanation: The 8 and -8 collide
		 * exploding each other. Example 3:
		 * 
		 * Input: asteroids = [10,2,-5] Output: [10] Explanation: The 2 and -5 collide
		 * resulting in -5. The 10 and -5 collide resulting in 10.
		 */
	}

}
