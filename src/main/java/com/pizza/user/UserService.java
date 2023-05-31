package com.pizza.user;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No User with what ID"));
    }


    public String showBasicUserDetails(Long id){
        User user = getUserById(id);
        if(user == null){
            System.out.println("No User found..");
        }

        System.out.println("user: " + user.getFirstname());
        return user.getId() + user.getFirstname() + user.getLastname() + user.getEmail();
    }
}
