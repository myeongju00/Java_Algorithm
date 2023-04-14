import java.util.*;

class Solution {
    HashSet<Integer> numberSet = new HashSet<>();

    public boolean isPrime(int num) {
        if(num == 1 || num == 0) {
            return false;
        }

        //아리스토테네스의 체
        int limit = (int) Math.sqrt(num);

        //limit까지 배수 여부를 확인
        for(int i = 2; i <= limit; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }

        // 나올 수 있는 최대의 조합을 구하기
        public void recursive(String comb, String others) {
            if(!comb.equals("")) {
                numberSet.add(Integer.parseInt(comb));
            }
    
            // 2. 남은 숫자 중 한개를 더해 새로운 조합 생성
            for(int i = 0; i < others.length(); i++) {
                if(!comb.equals("")) {
                    numberSet.add(Integer.valueOf(comb));
                }
    
                recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
            }
        }

    public int solution(String numbers) {
        int count = 0;
        
        // 1. 만들수 있는 모든 조합의 숫자를 만든다.
        recursive("", numbers);

        // 2. 소수의 개수만 센다.
        Iterator<Integer> it = numberSet.iterator();

        while(it.hasNext()) {
            int number = it.next();

            if(isPrime(number)) {
                count ++;
            }
        }
        
        // 3. 소수의 개수를 반환한다.
        return count;
    }
}