//��¦�h���O
//CFD_check: Class FunDation_check (��¦�h-�ˬd���O)
public class CFD_check {
    //�ˬd�ǤJ���r��O�_���ѼƦr�զ�
    public boolean checkNumber(String s){
 
        int checkResult = 1;   //�]�w�ˬd���G�����1
        int len = s.length();  //���o�ǤJ�r�����(len)
        String[] sList = new String[len];   //�إߤ@�Ӫ��׬�len���r��}�C,�Ψ��x�s�r���ѫ�U�Ӧr����
        
        //�N�r���Ѧ��@�ӭӦr��,���x�s��}�CsList��,�Ҧp: s="abc98", sList={"a","b","c","9","8"};
        for(int x=0; x<len-1; x++)
            sList[x] = s.substring(x,x+1);

        sList[len-1] = s.substring(len-1);

        //�v�@����sList���C�@�����ˬd�O�_�ݩ�0~9���Ʀr�r��,�`�N:�Ĥ@�Ӧr���u��1~9.
        //�u�n�����@�Ӧr�����ݩ�Ʀr�r��,�h isNumber = 0, checkResult�u�n����@��0�N�|�ܬ�0
        for(int x=0; x<len; x++){

            int isNumber = 0;
            int startIndex = 0;

            if( x == 0 )
                  startIndex = 1;
            else 
                  startIndex = 0;

            for(int y=startIndex; y<10; y++){
                  if( sList[x].equals( String.valueOf(y) )  ) isNumber = 1;
            }
            checkResult = checkResult * isNumber;
        }
   
        //�p�GcheckResult����1�N��C�Ӧr�����O�Ʀr�r��,�B�Ĥ@�ӥu��1~9,�������T����Ʈ榡
        if( checkResult == 1 )
              return(true);
        else
              return(false);

    }

} //end for: class CFD_check