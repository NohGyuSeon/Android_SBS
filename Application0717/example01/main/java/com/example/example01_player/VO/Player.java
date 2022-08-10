package com.example.example01_player.VO;

public class Player implements Comparable<Player>{
    private String name;
    private int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Player player) {
        // Player 간의 우선순위(크기)를 비교하기 위한 메서드

        // 음수 : 해당 객체가 크기가 작은 경우
        //        → 정렬할 때 앞으로 온다.
        // 양수 : 해당 객체가 크기가 큰 경우
        //        → 정렬할 때 뒤으로 온다.
        //   0  : 두 객체가 크기가 같은 경우
        //-----------------------------------------------
        // 점수 내림차순으로 만들어야하기 때문에
        // 점수그 클수록 앞으로 정렬되도록 구현

        if(this.score != player.score)
            return player.score - this.score;
    
        // 점수가 같은 경우 이름순
        return name.compareTo(player.name);
    }
}
