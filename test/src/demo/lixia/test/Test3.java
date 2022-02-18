package demo.lixia.test;

/**
 * 用归并排序将3，1，4，1，5，9，2，6 排序。
 * @author lixia
 *
 */
public class Test3 {

	public static void main(String[] args) {
		int[] arr = {3, 1, 4, 1, 5, 9, 2, 6};
		sort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void sort(int[] arr, int start, int end) {
		partition(arr, start, end);
	}
	
	private static  void partition(int[] arr,int start,int end){
		if(start < end){
			int mid = (start+end)/2;
			partition(arr,start,mid);
			partition(arr,mid+1,end);
			//合并划分后的数组
			merge(arr, start, end, mid);
		}
	}
	private static void merge(int[] arr,int start,int end,int mid){
		int i = start;
		int j = mid+1;
		int t = 0;
		int[] temp = new int[arr.length];
		while(i<=mid && j<=end){
			//将两个指针指向的数中较小的那个放入临时数组
			if(arr[i] <= arr[j]){
				temp[t] = arr[i];
				t++;
				i++;
			}else if(arr[i] > arr[j]){
				temp[t] = arr[j];
				t++;
				j++;
			}
		}
		//把左边剩余填入临时数组
		while(i <= mid){
			temp[t] = arr[i];
			t++;
			i++;
		}
		//把右边剩余填入临时数组
		while(j <= end){
			temp[t] = arr[j];
			t++;
			j++;
		}
		//将临时数组拷贝回原数组
		t = 0;
		while(start <= end){
			arr[start] = temp[t];
			start++;
			t++;
		}
	}
	
}
