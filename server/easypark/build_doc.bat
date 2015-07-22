java -jar jersey-doc-generator.jar -p "./war/WEB-INF/classes" -d "./war/WEB-INF/lib" -c "com.robocorp2.API.ParkingAPI" -o "./war/doc/ParkingAPI.json"

java -jar jersey-doc-generator.jar -p "./war/WEB-INF/classes" -d "./war/WEB-INF/lib" -c "com.robocorp2.API.PlacesAPI" -o "./war/doc/PlacesAPI.json"

java -jar jersey-doc-generator.jar -p "./war/WEB-INF/classes" -d "./war/WEB-INF/lib" -c "com.robocorp2.API.StructureAPI" -o "./war/doc/StructureAPI.json"

java -jar jersey-doc-generator.jar -p "./war/WEB-INF/classes" -d "./war/WEB-INF/lib" -c "com.robocorp2.API.CheminAPI" -o "./war/doc/CheminAPI.json"