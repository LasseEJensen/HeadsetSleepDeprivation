# HeadsetSleepDeprivator

## Caution and Advice

**Important Notice:** I have about three months of programming experience, and this software has not been vetted by an experienced programmer. **It is highly advised to wait with using this program until it has been reviewed and verified as safe to run by a qualified individual.** Ideally, users should wait until a verified and possibly improved version is available in a branch created by someone with more experience. Users are also encouraged to review the source code themselves for additional assurance.

HeadsetSleepDeprivator is a lightweight utility designed to prevent headsets from automatically turning off due to inactivity. It operates by discreetly playing a 20Hz tune for 10 seconds every 3 minutes at a low, unnoticeable volume. This application is ideal for users who need their headsets to remain powered on continuously without manual intervention.

## Features

- **Automated Function**: Prevents headset from sleeping by simulating audio output.
- **Unobtrusive**: Works entirely in the background, with minimal impact on system resources.
- **Customizable**: Users can adjust operation parameters via a configuration file.

## Installation

HeadsetSleepDeprivator does not have a formal installer. Users will need to either compile the source code or run the provided `.jar` file.

### Running the JAR File

If you have Java installed, you can run the application directly from the `.jar` file:
java -jar HeadsetSleepDeprivator.jar

### Compiling from Source

To compile the application from source, ensure you have:

- Java Development Kit (JDK) 14 or newer

## Configuration

The application generates a `config.txt` file upon the first run. Users can edit this file to customize the following parameters:

- `duration`: Duration of the tone played (in milliseconds).
- `frequency`: Frequency of the tone (in Hz).
- `sleeptime`: Time between each tone playback (in milliseconds).
- `volume`: Volume of the tone (scale 0 to 1).

Modify these values according to your needs and save the file. The application will read these settings on the next run.

## File Integrity

To ensure the integrity of the files, you can verify the SHA-256 hashes of the source file and the executable JAR:

- **Source file (HeadsetSleepDeprivator.java)**:
  - SHA-256: 663C2AB982AA2F7E7E7B6DFC4204AFEAFAF0512B14A01E0709E26D334AE27977

- **Executable JAR (HeadsetSleepDeprivator.jar)**:
  - SHA-256: 68946F0B27512436653CE55D370CF013679EDF46DCFBD5C1814B562C57718E61

**Users are strongly encouraged not to run the software without confirming these hashes match those listed here, especially when downloaded from sources other than the official GitHub repository.**

## Usage

Once the application is running, it will automatically start operating in the background:

- **No User Interface**: There is no interface or interaction required. The application silently prevents the headset from sleeping.
- **Termination**: If you need to stop the application, you can terminate its process via the Task Manager. Look for a process named `java.exe` or `javaw.exe` in the taskmanager "detail" section.

## License

This project is open source and available under the MIT License. You are free to use, modify, and distribute the software in any way.

## Disclaimer

The author is not responsible for any use of the program or any consequences thereof.
