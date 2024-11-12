public class OurPair<K, V> implements Pair<K, V>{
    private K key;
    private V value;
    
    public void setPair(K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey(){
        return this.key;
    }

    @Override
    public V getValue(){
        return this.value;
    }
}

