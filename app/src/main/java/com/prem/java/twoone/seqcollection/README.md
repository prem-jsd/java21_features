
'''

Sequenced Collections fill the lack of a collection type that represents a sequence of elements with a defined 
encounter order. Besides that, a uniform set of operations were absent that apply such collections

Collections.unmodifiableSequencedCollection(sequencedCollection)
Collections.unmodifiableSequencedSet(sequencedSet)
Collections.unmodifiableSequencedMap(sequencedMap)

A sequenced collection is a Collection whose elements have a predefined encounter order. 
The new interface SequencedCollection is:

interface SequencedCollection<E> extends Collection<E> {
    // new method
    SequencedCollection<E> reversed();
    // methods promoted from Deque
    void addFirst(E);
    void addLast(E);
    E getFirst();
    E getLast();
    E removeFirst();
    E removeLast();
}


A sequenced set is a Set that is a SequencedCollection that contains no duplicate elements. The new interface is:

interface SequencedSet<E> extends Set<E>, SequencedCollection<E> {
    SequencedSet<E> reversed();    // covariant override
}


A sequenced map is a Map whose entries have a defined encounter order. The new interface is:

interface SequencedMap<K,V> extends Map<K,V> {
    // new methods
    SequencedMap<K,V> reversed();
    SequencedSet<K> sequencedKeySet();
    SequencedCollection<V> sequencedValues();
    SequencedSet<Entry<K,V>> sequencedEntrySet();
    V putFirst(K, V);
    V putLast(K, V);
    // methods promoted from NavigableMap
    Entry<K, V> firstEntry();
    Entry<K, V> lastEntry();
    Entry<K, V> pollFirstEntry();
    Entry<K, V> pollLastEntry();
}


'''