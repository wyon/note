package com.wyon.algorithm;

import java.util.Arrays;

public class SortAlgorithm {

    /* 插入排序 */
    // 直接插入排序 On2 稳定
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0 && (arr[j] > temp); j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = temp;
        }
    }

    // 希尔排序 Onlog2n～On2  不稳定
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int len = arr.length;
        for (int gap = len / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < len; i += gap) {
                int temp = arr[i];
                int j = i - gap;
                for (; j >= 0 && (arr[j] > temp); j -= gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = temp;
            }
        }
    }

    /* 选择排序 */
    // 简单选择排序 On2 稳定
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int pos;
        for (int i = 0; i < arr.length - 1; i++) {
            pos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            if (pos != i) {
                swap(arr, i, pos);
            }
        }
    }

    // 堆排序 Onlogn 不稳定
    public static void heapSort(int[] arr) {
        HeapSort.sort(arr);
    }

    /* 交换排序 */
    // 冒泡排序  On2  稳定
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0, size = arr.length; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // 快速排序 冒泡排序优化，Onlogn 空间复杂度Onlogn 不稳定
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        QuickSort.qSort(arr, 0, arr.length - 1);
    }

    // 归并排序 Onlogn 空间复杂度On 稳定
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
//        MergeSort.sortRecursion(arr);
        MergeSort.sortIterator(arr);
    }

    // 基数排序 Ok(n+d) 空间复杂度On 稳定
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        //初始化count数组
        int[] counter = new int[10];
        //初始化一个新的数组存放排序后的元素
        int[] result = new int[arr.length];
        int[] src = arr;
        int[] temp;
        int max = getMax(src);
        // 当exp=1表示按照"个位"对数组a进行排序
        // 当exp=10表示按照"十位"对数组a进行排序
        // 当exp=100表示按照"百位"对数组a进行排序
        int exp = 1;
        for (; max / exp > 0; exp *= 10) {
            countSort(src, result, counter, exp);
            temp = result;
            result = src;
            src = temp;
        }
        if (arr != src) {
            System.arraycopy(src, 0, arr, 0, src.length);
        }
    }

    private static void countSort(int[] arr, int[] result, int[] counter, int exp) {
        //为输入数组中每个元素计数
        Arrays.fill(counter, 0);
        for (int v : arr) {
            counter[(v / exp) % 10]++;
        }
        //计算各个数之前元素的总和
        for (int i = 1; i < counter.length; i++) {
            counter[i] = counter[i] + counter[i - 1];
        }
        int index;
        for (int i = arr.length - 1; i >= 0; i--) {
            //把A[j]放到对应的位置
            index = (arr[i] / exp) % 10;
            result[counter[index] - 1] = arr[i];
            //计数器减一
            counter[index]--;
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void println(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static class HeapSort {
        static void sort(int[] arr) {
            if (arr == null || arr.length <= 1) {
                return;
            }
            maxHeapSort(arr);
        }

        static void maxHeapSort(int[] arr) {
            buildMaxHeap(arr);
            for (int i = arr.length - 1; i > 0; i--) {
                swap(arr, 0, i);
                maxHeapfy(arr, i, 0);
            }
        }

        static void buildMaxHeap(int[] arr) {
            int lastParent = getParentIndex(arr.length - 1);
            for (; lastParent >= 0; lastParent--) {
                maxHeapfy(arr, arr.length, lastParent);
            }
        }

        static void maxHeapfy(int[] arr, int size, int root) {
            int left = getLeftChild(root);
            int right = getRightChild(root);
            int largestIndex = root;
            if (left < size && arr[left] > arr[largestIndex]) {
                largestIndex = left;
            }
            if (right < size && arr[right] > arr[largestIndex]) {
                largestIndex = right;
            }
            if (largestIndex != root) {
                swap(arr, root, largestIndex);
                maxHeapfy(arr, size, largestIndex);
            }
        }

        static int getParentIndex(int index) {
            return (index - 1) >> 1;
        }

        static int getLeftChild(int index) {
            return (index << 1) + 1;
        }

        static int getRightChild(int index) {
            return (index << 1) + 2;
        }

        static void swap(int[] arr, int i, int j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    static class MergeSort {

        static void sortIterator(int[] arr) {
            int[] temp = new int[arr.length];
            for (int gap = 1; gap < arr.length; gap *= 2) {
                for (int i = 2 * gap; i - gap < arr.length; i += gap * 2) {
                    merge(arr, temp, i - 2 * gap, i - gap - 1, Math.min(i - 1, arr.length - 1));
                }
            }
        }

        static void sortRecursion(int[] arr) {
            int[] temp = new int[arr.length];
            sortTop2Bottom(arr, temp, 0, arr.length - 1);
        }

        static void sortTop2Bottom(int[] arr, int[] temp, int left, int right) {
            if (left < right) {
                int center = (left + right) >> 1;
                sortTop2Bottom(arr, temp, left, center);
                sortTop2Bottom(arr, temp, center + 1, right);
                merge(arr, temp, left, center, right);
            }
        }

        static void merge(int[] arr, int[] temp, int left, int center, int right) {
            int pos = left;
            int leftPos = left;
            int rightPos = center + 1;
            while (leftPos <= center && rightPos <= right) {
                temp[pos++] = arr[leftPos] < arr[rightPos] ? arr[leftPos++] : arr[rightPos++];
            }
            while (leftPos <= center) {
                temp[pos++] = arr[leftPos++];
            }
            while (rightPos <= right) {
                temp[pos++] = arr[rightPos++];
            }
            System.arraycopy(temp, left, arr, left, right - left + 1);
        }
    }

    static class QuickSort {
        // https://blog.csdn.net/qq_36528114/article/details/78667034

        static void qSort(int[] arr, int left, int right) {
            if (left >= right) {
                return;
            }
            //当序列较短时，采用直接插入
//            if ((right - left) <= 5) {
//                InsertSort(array, right - left + 1);
//            }
//            int index = partSort1(arr, left, right);
//            int index = partSort2(arr, left, right);
            int index = partSort3(arr, left, right);
            qSort(arr, left, index - 1);
            qSort(arr, index + 1, right);
        }

        // 左右指针法
        static int partSort1(int[] arr, int left, int right) {
            swap(arr, right, getMid(arr, left, right));
            int key = arr[right];
            int keyPos = right;
            while (left < right) {
                while (left < right && arr[left] <= key) { //因为有可能有相同的值，防止越界，所以加上left < right
                    left++;
                }
                while (left < right && arr[right] >= key) {
                    right--;
                }
                swap(arr, left, right);
            }
            swap(arr, left, keyPos);
            return left;
        }

        // 挖坑法
        static int partSort2(int[] arr, int left, int right) {
            swap(arr, right, getMid(arr, left, right));
            int key = arr[right];
            while (left < right) {
                while (left < right && arr[left] <= key) {
                    left++;
                }
                arr[right] = arr[left];
                while (left < right && arr[right] >= key) {
                    right--;
                }
                arr[left] = arr[right];
            }
            arr[right] = key;
            return right;
        }

        //前后指针法
        static int partSort3(int[] arr, int left, int right) {
            swap(arr, right, getMid(arr, left, right));
            if (left < right) {
                int key = arr[right];
                int cur = left;
                int pre = left - 1;
                while (cur < right) {
                    while (arr[cur] < key && ++pre != cur) {
                        swap(arr, cur, pre);
                    }
                    cur++;
                }
                swap(arr, ++pre, right);
                return pre;
            }
            return -1;
        }

        // 三数取中
        static int getMid(int[] arr, int left, int right) {
            int mid = (left + right) >> 1;
            if (arr[left] <= arr[right]) {
                if (arr[mid] < arr[left]) {
                    return left;
                } else if (arr[mid] > arr[right]) {
                    return right;
                } else {
                    return mid;
                }
            } else {
                if (arr[mid] < arr[right]) {
                    return right;
                } else if (arr[mid] > arr[left]) {
                    return left;
                } else {
                    return mid;
                }
            }
        }

        static void swap(int[] arr, int i, int j) {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}
