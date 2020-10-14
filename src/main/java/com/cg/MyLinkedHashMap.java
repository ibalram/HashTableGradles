package com.cg;

import java.util.ArrayList;

public class MyLinkedHashMap<K, V> {
	private final int numBuckets;
	ArrayList<LinkedList<K>> bucketArray;

	public MyLinkedHashMap() {
		this.numBuckets = 10;
		this.bucketArray = new ArrayList<>(numBuckets);
		for (int i = 0; i < numBuckets; ++i)
			this.bucketArray.add(null);
	}

	private int getBucketIndex(K key) {
		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % numBuckets;
		System.out.println("Key: " + key + " hashCode: " + hashCode + " index: " + index);
		return index;
	}

	public V get(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);
		if (linkedList == null)
			return null;
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) linkedList.find(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	public void add(K key, V value) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);
		if (linkedList == null) {
			linkedList = new LinkedList<K>();
			this.bucketArray.set(index, linkedList);
		}
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) linkedList.find(key);
		if (myMapNode == null) {
			myMapNode = new MyMapNode<>(key, value);
			linkedList.append(myMapNode);
		} else {
			myMapNode.setValue(value);
		}

	}

	public void remove(K key) {
		int index = this.getBucketIndex(key);
		LinkedList<K> linkedList = this.bucketArray.get(index);
		if (linkedList == null)
			return;
		MyMapNode<K, V> myMapNode = (MyMapNode<K, V>) linkedList.find(key);
		if (myMapNode != null)
			linkedList.remove(myMapNode.getKey());
	}

}
