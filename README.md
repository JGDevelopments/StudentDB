# StudentDB 
# README if you want to know EVERYTHING about this project..... I mean everything :)


    Annotations

        DemoApplication
	    - @SpringbootApplication =

	    Student
	    - @Entity = So the @Entity annotation maps the class to a DB and if the class isn't specified in
	        @Entity name = "Example" than whatever class it is placed above it will take the name by default

	    - @ID = Without the ID annotation in this context you'll receive a no identification error (Caused by: org.hibernate.AnnotationException: No identifier specified for entity: )
	                so you need to insert it above your id var. In general you should always include a unique primary key.
	    - @SequenceGenerator = This produces a sequence which is used for generating a primary key, under name and sequence name your just naming your sequence
	                              but the allocation size actually represents what increments it will go up or down by.
	    - @GeneratedValue = (
                                        strategy = GenerationType.SEQUENCE,
                                        generator = "student_sequence")

                                       Generator:  The generator in this scenario is used to determine what the primary generator will be
                                        in this instance our primary generator will be coming from the SequenceGenerator so here
                                        were just specifying the name as declared above

                                        Strategy: I'm pretty sure this just identifies how were generating the primary key and the fact that
                                        in this instance were explicitly using a SEQUENCE

	    - @Transient = This is pretty sweet and simple. Transient makes your db entry "Transparent". Essentially, it doesn't populate on your DB but remains functional.
	    - @Override = This guy just lets the compiler know that you did mean to use the same method in the same class with different parameters. :)

	   Student Service
	    - @Service = This annotation is used to describe that the Component is of a service type
	    - @Autowired - This annotation is used to autowire bean on the setter method. 
	    - @Transactional =

	    Student Repository
	    - @Repository =
	    - @Query =

	    Student Controller
	    - @RestController = This annotation is used to implement RESTful web services in a declarative way. 
			The annotation is applied to a class and this marks it as a request handler, Spring sees this 
			and provides those RESTful web services during runtime 
	    - @RequestMapping =
	    - @GetMapping = This handles the HTTP GET request and is matched with a given url
 	    - @PostMapping = This maps the HTTP POST request into a specific method 
	    - @PutMapping =
	    - @RequestParam =
	    - @PathVariable =
	    - @DeleteMapping = This maps the HTTP DELETE request into a specific method




	    StudentConfig.java  
 		- @Configuration = This is used to tell spring that the class is going to need Spring Beans generated. 
 		- @Bean = This is applied to our Commandlinerunner method to specify that the returned bean will be managed
		 		by Spring Context(Application Context)

	@Bean
    - CommandLineRunner commandLineRunner (StudentRepository repository)

	+ What does this line mean?

		- Essentially were running the CommandLineRunner as a bean and this is used to indicate
		  that this code will run right after application startup and uses the array as an argument




	File Name and Default Configuration

	    - So the file names are to make this easier later down the road about what is what.
	        Lets say for some reason your having to search through a monolithic application and there are a whole, bunch of similar names.
	        You would want to be able to know what is what fairly easily. Technically this is lacking the MVC package structure, but I have made an exception
	        for this tiny application.

	    - The directory and package configuration (excluding student) is automatically done by Springboot! :) It's pretty handy I would say.



    Somewhat complicated looking lines of code :)
    Also some, of the logic behind the email verification and saving into the DB :)


        -  public String toString() {
                  return "StudentData{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", dob=" + dob + ", age=" + age + '}';
              }

              + This Method is the toString() which returns the object as a String representation





    RESTful API

        - @RequestMapping(path = "api/v1/student") = this is a REST endpoint
            api = Shows that this is the API portion of the endpoint
            v1 = shows what version of the API were using
            student = the Resource


        - POST http://localhost:8080/api/v1/student
            = this indicates what operation were using such as post, put, get and delete


        - Content-Type: application/JSON

          {
            "name": "Michelle",
            "email": "MichelleIsAwesome@CareFirst.Elevate.edu",
            "dob": "1995-12-12"
          }
           = this is what's called the parameter or body it makes up the data portion of post method

            + If your familliar with CRUD this shows the translation to RESTful HTTP Methods

                 C = Create    ||      P = Post
                 R = Read      ||      G = Get
                 U = Update    ||      P = Put
                 D = Delete    ||      D = Delete

            + Using this IDE and spring setup we will be using the generated-request.http api to send data or request it

            + Generally it will look like this all together, its considered good practice to specify the application type
                            - typically it will be using JSON

           POST http://localhost:8080/api/v1/student
            Content-Type: application/JSON

                     {
                       "name": "Michelle",
                       "email": "MichelleIsAwesome@CareFirst.Elevate.edu",
                       "dob": "1995-12-12"
                     }