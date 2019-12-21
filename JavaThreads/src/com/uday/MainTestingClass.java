package com.uday;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class ForkJoinExample extends RecursiveTask<Integer> {
	int arr[], start, end, searchElement;

	public ForkJoinExample(int arr[], int start, int end, int searchElement) {
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.searchElement = searchElement;
	}

	@Override
	protected Integer compute() {
		int size = end - start + 1;
		if (size > 3) {
			int mid = (end + start) / 2;
			ForkJoinExample task1 = new ForkJoinExample(arr, start, mid, searchElement);
			ForkJoinExample task2 = new ForkJoinExample(arr, mid + 1, end, searchElement);
			task1.fork();
			task2.fork();
			int result = task1.join() + task2.join();
			return result;
		} else {
			return processSearch();
		}
	}

	private Integer processSearch() {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = start; i <= end; i++) {
			if (arr[i] == searchElement)
				count++;
		}
		return count;
	}

}

class MainTestingClass {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 7, 8, 9, 6, 2, 5 };
		int searchElement = 2;
		int start = 0;
		int end = arr.length - 1;
		ForkJoinPool pool = ForkJoinPool.commonPool();
		ForkJoinExample task = new ForkJoinExample(arr, start, end, searchElement);
		int result = pool.invoke(task);
		System.out.println("found " + searchElement + "  " + result + " times");
	}
}
