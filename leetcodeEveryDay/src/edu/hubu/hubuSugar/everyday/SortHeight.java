package edu.hubu.hubuSugar.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: sugar
 * @date: 2022/5/12
 * @description: 按照身高和体重排序
 */
public class SortHeight {

    public List<Integer> sortHeightAndWeight(int[] height, int[] weight){
        List<Integer> result = new ArrayList<>();
        int len = height.length;
        Student[] students = buildAndSortData(height, weight);
        int mark = 0;
        int index = 0;
        while(index < len){
            while(index + 1 < len && students[index + 1].height.equals(students[index].height)){
                index++;
            }
            sort(students,mark,index);
            index++;
            mark = index;
        }
        for(Student student:students){
            result.add(student.sort);
        }
        return result;
    }

    public static Student[] buildAndSortData(int[] height, int[] weight){
        int len = height.length;
        Student[] students = new Student[len];

        for(int i = 0; i < len;i++){
            students[i] = new Student(height[i], weight[i],i + 1);
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.height.compareTo(o2.height);
            }
        });
        return students;
    }

    public int quickSort(Student[] students,int left,int right){
        Student base = students[left];
        while(left < right){
            while(left < right && students[right].weight >= base.weight){
                right--;
            }
            students[left] = students[right];

            while(left < right && students[left].weight <= base.weight){
                left++;
            }
            students[right] = students[left];
        }
        students[left] = base;
        return left;
    }

    public void sort(Student[] students,int start,int end){
        if(start < end){
            int index = quickSort(students, start, end);
            sort(students, start, index - 1);
            sort(students, index + 1, end);
        }
    }

    public static void main(String[] args) {

        int[] height = {100, 100,100, 200,200, 300};
        int[] weight = {40, 30,50, 50,60, 60};
        System.out.println(new SortHeight().sortHeightAndWeight(height, weight));

    }

    public static class Student{
        public Integer height;
        public Integer weight;
        public int sort;

        public Student(int height, int weight,int sort) {
            this.height = height;
            this.weight = weight;
            this.sort = sort;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "height=" + height +
                    ", weight=" + weight +
                    ", sort=" + sort +
                    '}';
        }
    }
}
