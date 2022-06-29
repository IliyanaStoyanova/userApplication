**The application has the following structure:**
- src
  - main
    - java
      - com.iliyana.userapplication
        - controller
          - ApiController.java
          - model 
            - User.java
          - repository
            - UserRepo.java
          - service
            - impl
              - UserServiceImpl.java
              - UserService.java
    - resources
      - application.properties - username and password as per your MySQL installation

**Application features:**
1. Reading all the users. 
   We create these functions:
     function in UserServiceImpl: getUsers()
      - input - without params 
      - use findAll() from userRepo
      - output - List<User> -> list with User in json format
      ```bash
      @Override
        public List<User> getUsers() {
        return userRepo.findAll();
      }
      ```
     function in ApiController:
        - `get method - /users`
        - call getUsers() function from the service and return List with information for all users.
       ```bash
          @GetMapping()
             public List<User> getUsers() {
             return userService.getUsers();
          }
       ```
2. Reading one user.
    We create these functions:
      function in UserServiceImpl: getUsersId(long id)
        - input - user id param
        - use findById(id) from userRepo
        - output - User object
       ```bash
       @Override
       public User getUsersId(long id) { 
          return userRepo.findById(id).get();
       }
        ```
      function in ApiController: 
       - `get method - /users/id`
       - call getUsersId(id) - function from the service and return User object with information for one user.
      ```bash
       @GetMapping(value = "/{id}")
       public User getUsersId(@PathVariable long id) {
          return userService.getUsersId(id);
       }
      ```
3. Display information according to the criteria for the selected sorting and search in URL params.
   We create these functions:
      function in UserServiceImpl: filterUsers(String item, Sort sort)
        - input - search item and Sort Object
        - use filterUsers(item, sort) from UserRepo -> with Query annotation where we are looking for a string
         in firstName and lastName
        - output - a list of users with the search criteria and the specified sort(field and direction)
      ```bash      
       @Override
        public List<User> filterUsers(String item, Sort sort) {
           return userRepo.filterUsers(item, sort);
        }
      ```
      function in ApiController:
        - `get method - /users/filter?item=<SEARCH_STRING>&field=<SORT_FIELD>&dir=<DIRECTION>`
        - call filterUsers - function from the service and return List<User>
        - input params are: 
            -> item - search string with defaultValue - ""
            -> field - sort field with defaultValue  - id
            -> dir - sorting direction with defaultValue - asc
      ```bash
      @GetMapping(value = "/filter")
      public List<User> filterUsers(@RequestParam(required = false, defaultValue = "") String item,
                                    @RequestParam(required = false, defaultValue = "id") String field,
                                    @RequestParam(required = false, defaultValue = "asc") String dir) { 
         return userService.filterUsers(item, Sort.by(Sort.Direction.fromString(dir), field));
      }
      ```
4. Add user in database.
    We create these functions:
        function in UserServiceImpl: addUser(User user)
          - input - User Object
          - use save function from UserRepo -> CrudRepository
          - output - User Object
      ```bash
       @Override
       public User addUser(User user) {
          return userRepo.save(user);
       }
      ```
        function in ApiController:
          - `post method - /users`
          - call addUser - function from the service and return inserted User Object
          - input param - request body User object
      ```bash
        @PostMapping()
        public User addUser(@RequestBody User user) {
           return userService.addUser(user);
        }
      ```
5. Updating a user.
    We create these functions:
       function in UserServiceImpl: updateUser(long id, User user)
          - input - user id, User Object
          - use save function from UserRepo -> CrudRepository
          - output - User Object
     ```bash
       @Override
       public User updateUser(long id, User user) {
           User updatedUser = userRepo.findById(id).get();
           updatedUser.setFirstName(user.getFirstName());
           updatedUser.setLastName(user.getLastName());
           updatedUser.setDateBirth(user.getDateBirth());
           updatedUser.setPhoneNumber(user.getPhoneNumber());
           updatedUser.setEmailAddress(user.getEmailAddress());
          return userRepo.save(updatedUser);
       }
    ```
       function in ApiController:
         - `put method - /users/id`
         - call updateUser - input user id, request body User object with information for update
      ```bash
      @PutMapping(value = "/{id}")
      public User updateUser(@PathVariable long id, @RequestBody User user) {
          return userService.updateUser(id, user);
      }
      ```
6. Deleting a user. 
    We create these functions:
        function in UserServiceImpl: deleteUser(long id) 
            - input - user id 
            - call deleteById from UserRepo
    ```bash
        @Override
        public void deleteUser(long id) {
            userRepo.deleteById(id);
        }
    ```
       function in ApiController:
            - `delete method - /users/id`
            - call deleteById from UserRepo - input user id
    ```bash
       @DeleteMapping(value = "/{id}")
       public void deleteUser(@PathVariable long id) {
           userService.deleteUser(id);
       }
    ```

**Description of the files:**
1. **controller/ApiController** -> controller describe all request mapping.
2. **model/User** -> Entity User Model. It describes all columns with user information and functions: setter/getter:
   - String firstName;
   - String lastName;
   - Date dateBirth;
   - String phoneNumber; 
   - String emailAddress;
3. **repository/UserRepo** -> this interface extends JpaRepository.
   This repo includes a user filtering feature with @Query annotation.
4. **service/UserService** -> interface declaration all functions. 
5. **service/impl/UserService** - implements UserService and Override all functions above.

