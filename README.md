## Chess Queen Challenge Project
### TECH DETAILS
 - [x] AWS Lambda Integration
 
 - [x] JAVA SE

  - [x] Maven

  - [x] JUnit

### CONTAINS
  - [x] Solving

 - [x]  Tests

  - [x] Error Handling

  - [x] Documentation
  
  ### Run App with Java
  
  ```bash
  clean install
  ```
  ### Run App with AWS Lambda
  
    ```bash
    clean install
    ```
- Copy .jar file to AWS Console.
- Create Success Test with 

  ```json
    {
      "chessSize": 5,
      "obstacleCount": 1,
      "queenPositionX": 2,
      "queenPositionY": 1,
      "obstaclePositionX": "[1]",
      "obstaclePositionY": "[1]"
    }
    ```
  
 - Create Failure Test with 
 
  ```json
     {
       "chessSize": 5,
       "obstacleCount": 1,
       "queenPositionX": 2,
       "queenPositionY": 1,
       "obstaclePositionX": "[1,2]",
       "obstaclePositionY": "[1,2]"
     }
     ```


### Problem 1 :
![alt text](https://s3.amazonaws.com/hr-challenge-images/0/1485426500-a4039ebb00-chess1.png)


Cevap 27.
Beyaz yuvarlakların sayısı Input : n: satranç tahtasının büyüklüğü nxn gibi Örnekte n=8 r : Vezirin y düzlemindeki(satır) konumu Örnekte r=4 c: Vezirin x düzlemindeki(sütun) konumu Örnekte c=4 Output: 27 Toplam yuvarlak sayısı

### Problem 2 :

![alt text](https://s3.amazonaws.com/hr-challenge-images/0/1485459132-3fdc1f1ca3-chess_4_.png
)


Vezirin önüne engel konulursa ?

Cevap 24.
Toplam beyaz yuvarlak sayısı Input : n: satranç tahtasının büyüklüğü nxn gibi Örnekte n=8 r : Vezirin y düzlemindeki(satır) konumu Örnekte r=4 (r<=n) c: Vezirin x düzlemindeki(sütun) konumu Örnekte c=4 (c<=n) k:engel sayısı engel: engel dizisi(satır sütun olarak) Output: 24 Toplam yuvarlak sayısı