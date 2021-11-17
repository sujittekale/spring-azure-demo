package com.app.mapper;

import com.app.model.Description;
import com.app.model.Image;
import com.app.model.ImageData;
import com.app.model.Product;
import com.app.model.ProductData;
import com.app.model.ProductDiscription;

public class ProductMapper {
	
	public static ProductData mapProuct(Product product,Description desc, Image image) {
		ProductData productData=new ProductData();
		productData.setId(product.getId());
		productData.setDiscounted(true);
		productData.setFinalPrice(product.getFinalPrice());
		productData.setProductCount(product.getProductCount());
		productData.setSortOrder(product.getSortOrder());
		productData.setVisible(true);
		
		productData.setProductDesc(mapProductDesc(desc));
		productData.setImageData(mapProuctImg(image));
		return productData;
		
	}
	
	private static ProductDiscription mapProductDesc(Description desc) {
		ProductDiscription productDesc=new  ProductDiscription();
		productDesc.setId(desc.getId());
		productDesc.setDescription(desc.getDescription());
		productDesc.setFriendlyUrl(desc.getFriendlyUrl());
		productDesc.setHighlights(desc.getHighlights());
		productDesc.setKeyWords(desc.getKeyWords());
		productDesc.setLanguage(desc.getLanguage());
		productDesc.setMetaDescription(desc.getMetaDescription());
		productDesc .setName(desc.getName());
		productDesc.setTitle(desc.getTitle());
		return productDesc;
	}

	public static ImageData mapProuctImg(Image product) {
		ImageData imageData=new ImageData();
		imageData.setId(product.getId());
		imageData.setExternalUrl(product.getExternalUrl());
		imageData.setImageName(product.getImageName());
		imageData.setImageType(product.getImageType());
		imageData.setVideoUrl(product.getVideoUrl());
		imageData.setDeafultImage(true);
		imageData.setImageUrl(product.getImageUrl());
		
		return imageData;
		
	}

}
