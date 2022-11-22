package com.larila.ecommer;

import com.larila.ecommer.model.entities.Brand;
import com.larila.ecommer.model.entities.enumerators.Brandtype;
import com.larila.ecommer.services.contracts.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BrandComands implements CommandLineRunner {


    @Autowired
    private BrandDAO servicio;

    Brand marca = null;
    @Override
    public void run(String... args) throws Exception {
        Brand marca = new Brand(null,"Trek",Brandtype.TODO);
        //Brand save = servicio.save(marca);
        //servicio.save(marca1);
        //servicio.save(marca2);
        //System.out.println(save.toString());


        /*
        Optional<Brand> oMarca = servicio.findById(2);
        if (oMarca.isPresent()){
            Brand result = oMarca.get();
            System.out.println(result.toString());
            //result.setBrandtype(Brandtype.TODO);
            //result.setName("Trek");
            //servicio.save(result);
        }else{
            System.out.println("no se encontro marca");
        }

        System.out.println(servicio.findById(2).orElse(new Brand()).toString());



         */


    }


}
