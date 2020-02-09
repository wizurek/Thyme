package com.example.skierowanie.serwis;

import com.example.Thyme.TestController;
import com.example.skierowanie.model.SkierowanieDoLekarza;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SkierowanieMapService implements SkierowanieService {


    private static final AtomicInteger atomicInteger = new AtomicInteger();
    private Map<Integer, SkierowanieDoLekarza> skierowanie = new HashMap<>();
    @Override
    public SkierowanieDoLekarza createSkierowanie(String lekarz, String pacjent, Date termin){
        int id = new Random().nextInt();
        SkierowanieDoLekarza skierowanieDoLekarza = new SkierowanieDoLekarza(id, lekarz, pacjent, termin);
        skierowanie.put(id, skierowanieDoLekarza);
        return skierowanieDoLekarza;
    }

    @Override
    public Collection<SkierowanieDoLekarza> listSkierowanie() {
        return skierowanie.values();
    }

    @Override
    public SkierowanieDoLekarza getSkierowanie(Integer id) {
        SkierowanieDoLekarza skierowanieDoLekarza = skierowanie.get(id);
        if (skierowanieDoLekarza == null) {
            throw new TestController.NotFoundException();
        }
        return skierowanieDoLekarza;
    }

    @Override
    public void deleteSkierowanie(Integer id) {
        skierowanie.remove(id);
    }

    @Override
    public SkierowanieDoLekarza updateSkierowanie(SkierowanieDoLekarza skierowanie) {
        SkierowanieDoLekarza existing = getSkierowanie(skierowanie.getId());
        existing.setLekarz(skierowanie.getLekarz());
        existing.setPacjent(skierowanie.getPacjent());
        existing.setTermin(skierowanie.getTermin());
        skierowanie.put(existing.getId(), existing);
        return existing;
    }


}