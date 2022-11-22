package com.larila.ecommer;


import com.larila.ecommer.model.entities.*;
import com.larila.ecommer.model.entities.enumerators.AdminType;
import com.larila.ecommer.repositories.BrandRepository;
import com.larila.ecommer.services.contracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.List;

@SpringBootApplication
public class LaRilaApplication {


	@Autowired
	private AdminDAO service;
	@Autowired
	private BrandRepository repository;
	@Autowired
	private NormalUserDAO servicio;
	@Autowired
	private BikeDAO bikeDAO;
	@Autowired
	private BrandDAO brandDAO;
	@Autowired
	private ModelDAO modelDAO;
	@Autowired
	private BikeTypeDAO bikeTypeDAO;
	@Autowired
	private  BikeSubTypeDAO bikeSubTypeDAO;
	@Autowired
	private  SizeDAO sizeDAO;



	public static void main(String[] args) {
		String[] definitionNames =  SpringApplication.run(LaRilaApplication.class, args).getBeanDefinitionNames();

		//List<Integer> auxA = new ArrayList<>();
		//auxA.remove(auxA.indexOf(2));



	}




	@Bean
	public CommandLineRunner runner(){
		return args -> {



			String[] order = {"name,asc"};

			for (String orders : order) {
				var split = orders.split(",");

			}


			//Page<Brand> marcas =  brandDAO.findAll(0,5,"id:desc","brandtype-brandtype:todo&");
			//marcas.forEach(System.out::println);
			//BikeType type = new BikeType(null, "Mountain Bike");
			//bikeTypeDAO.save(type);
			//Page<Brand> pagedbrand = (Page<Brand>) brandDAO.findAll(0,3,"id:desc,brandtype:asc","name>a,id>2");
			//Iterable<Brand> brands =  brandDAO.findAll("id:desc,brandtype:asc", "name>a");
			//Page<Product> bikePage =  bikeDAO.findAll(0,5,"id:desc","Product.price>10000");

			//Iterable<Product> bikes = bikeDAO.findAll("id:asc","status-status:nuevo%,name:amanos&,price>3458%");
			//bikes.forEach(System.out::println);

			//bikes.forEach(System.out::println);





			//pagedbrand.forEach(System.out::println);
			//Page<Product> productPage = (Page<Product>) productDAO.findAll("id:desc","id:1");
			//productPage.forEach(System.out::println);
			/*
			Sort sort = Sort.by(
					Sort.Order.asc("brandtype"),
					Sort.Order.desc("name")
			);

			List<Brand> brands = repository.findAll(brandSpecification,sort);
			List<Brand> marcas1 = (List<Brand>) brandDAO.findAll(0,10,order,brandSpecification);
			marcas1.forEach(System.out::println);

			 */
			//brands.forEach(System.out::println);


			//List<User> search5 = (List<User>) service.findAdminByType(AdminType.USERADMIN);
			//search5.forEach(System.out::println);
			//Bike save = (Bike) bikeDAO.save(bicicleta1);
			//System.out.println(save.toString());
			//User normalUser = new Admin(null,"Luis Fernando","Garcia Salmeron","raccoon69", "fernando69","123456", AdminType.USERADMIN);
			//User save = service.save(normalUser);
			//System.out.println(save.toString());


			Admin admin = new Admin(null,"fer","salme","mapache", "hey", "1234567890", AdminType.USERADMIN);
			NormalUser normalUser = new NormalUser(null,"Men", "Hey","El vato", "amonos", "123gdf");
			//service.save(admin);
			//servicio.save(normalUser);

			List<User> admins = (List<User>) service.findAll();
			admins.forEach(System.out::println);

			List<User> usuarios = (List<User>) servicio.findByName("Fernando");
			usuarios.forEach(System.out::println);







		};
	}




}
