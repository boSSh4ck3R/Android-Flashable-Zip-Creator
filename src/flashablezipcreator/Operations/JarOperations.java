/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashablezipcreator.Operations;

/**
 *
 * @author nikhil
 */
public class JarOperations {

    public boolean isExecutingJarFile() {
        return this.getClass().getResource("META-INF/com/google/android/Supported Devices").getPath().contains("!");
    }
}
