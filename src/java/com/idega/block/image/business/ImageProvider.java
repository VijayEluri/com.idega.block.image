/*
 * $Id: ImageProvider.java 1.1 May 2, 2006 eiki Exp $
 * Created on May 2, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.image.business;

import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.TransactionRolledbackLocalException;

import com.idega.block.image.data.ImageEntity;
import com.idega.business.IBOLookupException;
import com.idega.business.IBOService;
import com.idega.slide.business.IWSlideService;


/**
 * 
 *  Last modified: $Date: 2004/06/28 09:09:50 $ by $Author: eiki $
 * 
 * @author <a href="mailto:eiki@idega.com">eiki</a>
 * @version $Revision: 1.1 $
 */
public interface ImageProvider extends IBOService {

	/**
	 * @see com.idega.block.image.business.ImageProviderBean#getImageCount
	 */
	public int getImageCount(String imageFolderResourcePath) throws java.rmi.RemoteException;

	/**
	 * @see com.idega.block.image.business.ImageProviderBean#getImagesFromTo
	 */
	public ArrayList getImagesFromTo(String imageFolderResourcePath, int startPosition, int endPosition)
			throws java.rmi.RemoteException;

	/**
	 * @see com.idega.block.image.business.ImageProviderBean#getAllImagePathsForFolder
	 */
	public String[] getAllImagePathsForFolder(String folderURI) throws RemoteException;

	/**
	 * @see com.idega.block.image.business.ImageProviderBean#getIWSlideService
	 */
	public IWSlideService getIWSlideService() throws IBOLookupException, java.rmi.RemoteException;

	/**
	 * @see com.idega.block.image.business.ImageProviderBean#getContainedFolders
	 */
	public List getContainedFolders(String imageFolderResourcePath) throws java.rmi.RemoteException;

	/**
	 * @see com.idega.block.image.business.ImageProviderBean#uploadImage
	 */
	public int uploadImage(InputStream inputStream, String mimeType, String name, int width, int height,
			ImageEntity parent) throws CreateException, java.rmi.RemoteException;

	/**
	 * @see com.idega.block.image.business.ImageProviderBean#setHeightAndWidthOfOriginalImageToEntity
	 */
	public void setHeightAndWidthOfOriginalImageToEntity(int width, int height, ImageEntity imageEntity)
			throws TransactionRolledbackLocalException, java.rmi.RemoteException;
}
