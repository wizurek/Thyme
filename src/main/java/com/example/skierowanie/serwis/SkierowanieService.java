package com.example.skierowanie.serwis;

import com.example.skierowanie.model.SkierowanieDoLekarza;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;


public interface SkierowanieService {

    Collection<SkierowanieDoLekarza> listSkierowanie();
    SkierowanieDoLekarza getSkierowanie(Integer id);
    void deleteSkierowanie(Integer id);
    SkierowanieDoLekarza updateSkierowanie(SkierowanieDoLekarza skierowanie);
    SkierowanieDoLekarza createSkierowanie(String lekarz, String pacjent, Date termin);
}
