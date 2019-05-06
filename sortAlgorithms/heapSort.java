    public void heapSort(char[]chars){
        for( int i = 0;i< chars.length;i++){
            heapInsert(chars,i);
        }
        System.out.println(Arrays.toString(chars));
        for( int i = chars.length-1;i> 0;i--){
            swap(chars,0,i);
            heapify(chars,0, i);
        }
    }
    public void heapInsert(char[]chars, int i){
        int parent = 0;
        while(i>0){
            parent = (i-1)/2;
            if(chars[parent]<chars[i]){
                swap(chars,i,parent);
                i = parent;
            }else{
                break;
            }
        }
    }
    public void heapify(char[]chars, int i ,int size){
        int left = i*2+1;
        int right = i*2 +2;
        int largest = i;
        while(left<size){
            if(chars[left]>chars[i]){
                largest = left;
            }
            if(right<size&& chars[right]>chars[largest]){
                largest = right;
            }
            if(i == largest){
                break;
            }else{
                swap(chars,i,largest);
            }
            i = largest;
            right = i *2+2;
            left = i*2 +1;
        }
    }
    public void swap(char[]chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
