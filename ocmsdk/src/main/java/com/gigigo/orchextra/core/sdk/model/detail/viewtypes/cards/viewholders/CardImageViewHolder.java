package com.gigigo.orchextra.core.sdk.model.detail.viewtypes.cards.viewholders;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.gigigo.orchextra.core.domain.entities.article.ArticleImageElement;
import com.gigigo.orchextra.core.sdk.utils.DeviceUtils;
import com.gigigo.orchextra.core.sdk.utils.ImageGenerator;
import com.gigigo.orchextra.ocmsdk.R;
import com.gigigo.ui.imageloader.ImageLoader;

public class CardImageViewHolder extends CardViewElement {

  private ImageLoader imageLoader;
  private ImageView cardImagePlaceholder;
  private ArticleImageElement imageElement;

  public CardImageViewHolder(@NonNull Context context) {
    super(context);

    init();
  }

  public CardImageViewHolder(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);

    init();
  }

  public CardImageViewHolder(@NonNull Context context, @Nullable AttributeSet attrs,
      @AttrRes int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    init();
  }

  @Override public void initialize() {
    bindTo();
  }

  private void init() {
    LayoutInflater inflater =
        (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.view_card_image_item, this, true);

    initViews(view);
  }

  private void initViews(View view) {
    cardImagePlaceholder = (ImageView) view.findViewById(R.id.card_image_placeholder);
    view.setOnClickListener(fakeClickListener);
  }

  private View.OnClickListener fakeClickListener = new View.OnClickListener() {
    @Override public void onClick(View v) {

    }
  };

  private void bindTo() {
    if (imageElement != null) {
      setImage(imageElement.getImageUrl(), imageElement.getImageThumb());
    }
  }

  private void setImage(final String imageUrl, String imageThumb) {
    ImageGenerator.generateThumbImage(imageThumb, cardImagePlaceholder);

    int widthDevice = DeviceUtils.calculateRealWidthDevice(getContext());
    //int heightDevice = DeviceUtils.calculateRealHeightDevice(getContext());

    String generatedImageUrl = ImageGenerator.generateImageUrl(imageUrl, widthDevice);

    imageLoader.load(generatedImageUrl).into(cardImagePlaceholder).build();

    //ViewPager.LayoutParams lp = new ViewPager.LayoutParams(widthDevice, heightDevice);
    //cardImagePlaceholder.setLayoutParams(lp);
  }

  public void setImageLoader(ImageLoader imageLoader) {
    this.imageLoader = imageLoader;
  }

  public void setImageElement(ArticleImageElement imageElement) {
    this.imageElement = imageElement;
  }
}