# sales_taxes

Example project to sales taxes calculation.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java 11 or later
- Maven 3.5.4

### Installing

First you will need to clone the Git repository:

```https://github.com/marcofp/sales_taxes.git```

You can build and install the app on you local Maven repo with the following command.

```mvn clean install```

### Running unit tests

To run unit tests use:

```mvn test```

### Usage

```java -jar sales-boot/target/sales-boot-1.0.0-jar-with-dependencies.jar <data-memory-repository-path> <input-data-path>```

- ```<data-memory-repository-path>```: path to the csv file that contains the data repository in memory. For each row the format is ```<item-name>, <item-price>, <item-type>, <is-imported>```. For example: book, 12.49, BOOKS, false

- ```<input-data-path>```: path to the csv file that contains the input data. For each row the format is ```<item-name>, <item-quantity>```. For example: book, 1

- ```<item-type>```: BOOKS -> Books, FOODS -> Foods, MEDICAL -> Medical, MUSIC -> Music,  COSMETICS_PERFUMES_AND_CLEANING -> Cosmetics, Perfumes & Cleaning Substances, OTHERS -> Others

For example: 

```java -jar sales-boot/target/sales-boot-1.0.0-jar-with-dependencies.jar sample-data/repos/init-repository-1.csv sample-data/inputs/imput-1.csv```

Expected output:

1 book at 12.49
1 music CD at 16.49
1 chocolate bar at 0.85
Sales taxes: 1.50
Total: 29.83

```java -jar sales-boot/target/sales-boot-1.0.0-jar-with-dependencies.jar sample-data/repos/init-repository-2.csv sample-data/inputs/imput-2.csv```

Expected output:

1 imported box of chocolates at 10.50
1 imported bottle of perfume at 54.65
Sales taxes: 7.65
Total: 65.15

```java -jar sales-boot/target/sales-boot-1.0.0-jar-with-dependencies.jar sample-data/repos/init-repository-3.csv sample-data/inputs/imput-3.csv```

Expected output:

1 imported bottle of perfume at 32.19
1 bottle of perfume at 20.89
1 packet of headache pills at 9.75
1 box of imported chocolates at 11.85
Sales taxes: 6.70
Total: 74.68

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
