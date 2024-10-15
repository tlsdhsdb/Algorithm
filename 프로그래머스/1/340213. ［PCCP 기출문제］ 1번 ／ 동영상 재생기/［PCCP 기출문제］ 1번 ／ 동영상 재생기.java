class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int max_time = toSecond(video_len);
        int time = toSecond(pos);
        int start = toSecond(op_start);
        int end = toSecond(op_end);


        for(String command : commands){

            if(time >= start && time < end){
                time = end;
            }

            switch (command){
                case "next":
                    if(time + 10 > max_time){
                        time = max_time;
                    }else {
                       time += 10;
                    }
                    break;
                case "prev":
                    if(time - 10 < 0){
                        time = 0;
                    }else {
                        time -= 10;
                    }
                    break;
            }
            if(time >= start && time < end){
                time = end;
            }
        }

        return toTime(time);
    }

    static int toSecond(String time){
        String[] temp = time.split(":");

        int min = Integer.parseInt(temp[0]);
        int sec = Integer.parseInt(temp[1]);

        return min * 60 + sec;
    }

    static String toTime(int time){
        String min = String.format("%02d",time / 60);
        String sec = String.format("%02d",time % 60);

        return min + ":" + sec;
    }
}