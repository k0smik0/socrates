/*******************************************************************************
 * Copyleft 2013 Massimiliano Leone - massimiliano.leone@iubris.net .
 * 
 * InjectedTestRunner.java is part of 'Socrates'.
 * 
 * 'Socrates' is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * 'Socrates' is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with 'Socrates'; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301 USA
 ******************************************************************************/
package socrates.test.roboguiced.runner;

import org.junit.runners.model.InitializationError;

import roboguice.RoboGuice;
import roboguice.inject.ContextScope;
import android.content.Context;

import com.google.inject.Injector;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

public class InjectedTestRunner extends RobolectricTestRunner {
	
	public InjectedTestRunner(Class<?> testClass) throws InitializationError {
		super(testClass);
	}
	
	@Override 
	public void prepareTest(Object test) {		
		Context context = Robolectric.application.getApplicationContext();
//System.out.println(context);
	    Injector injector = RoboGuice.getInjector(context);
//System.out.println(injector);	    
	    ContextScope scope = injector.getInstance(ContextScope.class);
//System.out.println(scope);	    
	    scope.enter(context);
	    injector.injectMembers(test);
	}	
}
