package JianzhiOffer;
public class FirstAppearingOnce_55 {
    int[]hash = new int[256];
    int timestamp =0;

    //Insert one char from stringstream
    public void Insert(char ch) {
        timestamp++;
        if(hash[ch]==0){
            hash[ch]=timestamp;
        }
        else {
            hash[ch]=-1;//至少出现了两次
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int min = timestamp+1;
        char firstchar='#';
        for (int i = 0; i < 256; i++) {
             if(hash[i]!=-1&&hash[i]<min) {
                 min = hash[i];
                 firstchar =(char)i;
             }

        }
        return firstchar;
    }
    public static void main(String[]args){
        FirstAppearingOnce_55 it = new FirstAppearingOnce_55();
        System.out.println(it.FirstAppearingOnce());
    }
}
