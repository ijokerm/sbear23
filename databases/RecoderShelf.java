package databases;

import classes.Recoder;
import classes.User;
import exception.NotBorrowedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class RecoderShelf {
    private List<Recoder> recoderList=new ArrayList<>();

    private static RecoderShelf instance=new RecoderShelf();
    public static RecoderShelf getInstance() {
        return instance;
    }
    public boolean contains(User user,String ISBN){
        for(Recoder recoder:recoderList){
            if(recoder.is(user,ISBN)){
                return true;
            }
        }
        return false;
    }
    public void putRecorder(User user,String ISBN){
        Recoder recoder=new Recoder(user.getID(),ISBN);
    }

    public void remove(User user,String ISBN)throws NotBorrowedException {
        Iterator<Recoder>iterator=recoderList.iterator();
        while(iterator.hasNext()){
            Recoder recoder=iterator.next();
            if(recoder.is(user, ISBN)){
                iterator.remove();
                return;
            }
        }
        throw new NotBorrowedException();

        /*int index=-1;
        for(int i=0;i<recoderList.size();i++){
            Recoder recoder=recoderList.get(i);
            if(recoder.is(user,ISBN)){
                index=i;
                break;
            }
        }
        if(index==-1){
            throw new NotBorrowedException();
        }
        recoderList.remove(index);
    */
    }
    public List<Recoder>queryRecoder(Where<Recoder>where){
        List<Recoder>ret=new ArrayList<>();
        for(Recoder recoder:recoderList){
            if(where.test(recoder)){
                ret.add(recoder);
            }
        }
         return ret;
    }
}
