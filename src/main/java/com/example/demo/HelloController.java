package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(@RequestParam(defaultValue = "World", required = false) String name) {
        return "Hello " + name;
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam int[] numbers, String operator) {
        int result = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            switch (operator) {
                case "+":
                    result += numbers[i];
                    break;
                case "-":
                    result -= numbers[i];
                    break;
                case "*":
                    result *= numbers[i];
                    break;
                case "/":
                    result /= numbers[i];
                    break;
            }
        }
        return String.valueOf(result);
    }

    @GetMapping("/vowels")
    public String countVowels(@RequestParam String word) {
        int vowelCount=0;
        for (int i = 0; i < word.length(); i++) {
            if (String.valueOf(word.charAt(i)).matches("[aeiouAEIOU]")) {
                vowelCount++;
            }
        }
        return String.valueOf(vowelCount);
    }

    @PostMapping("/body")
    public String replaceWord(@RequestBody String body, @RequestParam String[] words) {
        return body.replace(words[0], words[1]);
    }


}
