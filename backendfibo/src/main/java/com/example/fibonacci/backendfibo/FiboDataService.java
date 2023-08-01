package com.example.fibonacci.backendfibo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class FiboDataService {

    @Autowired
    private FiboDataRepository fiboDataRepository;

    public List<Long> getFiboNo(Integer n) {
        List<Long> result = new ArrayList<Long>();
        if (fiboDataRepository.count() == 0) {
            fiboDataRepository.save(new FiboDataModel(1, 0));
            fiboDataRepository.save(new FiboDataModel(2, 1));
        }
        // Use google for reference to create
        // findByFiboIndexLessThanEqualOrderByFiboIndex
        List<FiboDataModel> fiboData = fiboDataRepository.findByFiboIndexLessThanEqualOrderByFiboIndex(n);
        result = fiboData.stream().map((i) -> i.getFiboValue()).toList();
        result.forEach(System.out::println);
        if (!fiboData.isEmpty()) {
            if (result.size() == n) {
                System.out.println("Already present in the DB");
                return result;
            } else {
                System.out.println("Computing from last value stored");
                return findFiboNo(n, result);
            }
        }
        return result;

    }

    // To find first N fibo numbers
    public List<Long> findFiboNo(int n, List<Long> result) {
        int len = result.size();
        Long prev1 = result.get(len - 2);
        Long prev2 = result.get(len - 1);
        Long current = 0L;
        List<Long> series = new ArrayList<>(List.copyOf(result));
        // System.out.println(prev1+"--"+prev2);
        int start = result.size() + 1;
        List<FiboDataModel> fiboDataToAdd = new ArrayList<>();
        for (int i = start; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
            // System.out.println("Inside for loop"+current);
            series.add(current);
            // System.out.println("Added Current to result");
            fiboDataToAdd.add(new FiboDataModel(i, current));
            // System.out.println("Add to save fibo data");
        }
        saveAllFiboData(fiboDataToAdd);
        return series;
    }

    // To save all the data in DB
    @Transactional
    public void saveAllFiboData(List<FiboDataModel> fiboData) {
        System.out.println("Inside Save all FiboData");
        fiboDataRepository.saveAll(fiboData);
    }

    // To find all the data in the Database
    public List<FiboDataModel> getAllFiboData() {
        return fiboDataRepository.findAll();
    }

}
