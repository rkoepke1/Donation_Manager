/**
 * Container Class that provides to store donation packages into a stack.
 * @author Ryan Koepke
 *
 */
package dataStructure;

import dataElements.DonationPackage;
import exceptions.ContainerException;
import interfaces.ContainerInterface;

public class Container implements ContainerInterface{
	MyStack<DonationPackage> packages;
	/**
	 * Default constructor initializes with a capacity set to the default value.
	 */
	public Container() {
		packages = new MyStack<>();
	}
	/**
	 * Constructor that initializes a new container with a specified capacity.
	 * @param initCap sets the capacity of the container.
	 */
	public Container(int initCap) {
		packages = new MyStack<>(initCap);	
	}
	
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage a DonationPackage Object to be stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException("The Container is Full") if the containerSize = containerCount (stack is full)
	 */
	@Override
	public boolean loadContainer(DonationPackage dPackage) throws ContainerException {
		if(!packages.isFull()) {
			packages.push(dPackage);
		}else {
			throw new ContainerException("Container is full.");
		}
		return true;
	}

	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws ContainerException("The Container is Empty") if there is no package in the container
	 */
	@Override
	public DonationPackage removePackageFromContainer() throws ContainerException {
		if(packages.isEmpty()) {
			throw new ContainerException("Container is empty.");
		}else {
			return packages.pop();
		}
	}

	/**
	 * Returns an array of the DonationPackages in the stack.  
	 * 
	 * @return an array of the DonationPackages in the stack
	 */
	@Override
	public DonationPackage[] toArrayPackage() {
		Object[] stackArray = packages.toArray();
		DonationPackage[] packageArray = new DonationPackage[stackArray.length];
		for(int i = 0; i < stackArray.length; i ++) {
			packageArray[i] = (DonationPackage)stackArray[i];
		}	
		return packageArray;
	}

}
