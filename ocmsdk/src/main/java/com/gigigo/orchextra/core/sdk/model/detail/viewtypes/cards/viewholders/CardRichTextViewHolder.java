package com.gigigo.orchextra.core.sdk.model.detail.viewtypes.cards.viewholders;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gigigo.orchextra.core.domain.entities.article.ArticleRichTextElement;
import com.gigigo.orchextra.ocmsdk.R;

public class CardRichTextViewHolder extends CardViewElement {

  private TextView cardRichText;
  private ArticleRichTextElement richTextElement;

  public CardRichTextViewHolder(@NonNull Context context) {
    super(context);

    init();
  }

  public CardRichTextViewHolder(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);

    init();
  }

  public CardRichTextViewHolder(@NonNull Context context, @Nullable AttributeSet attrs,
      @AttrRes int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    init();
  }

  private void init() {
    LayoutInflater inflater =
        (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.view_card_rich_text_item, this, true);

    initViews(view);
  }

  private void initViews(View view) {
    cardRichText = (TextView) view.findViewById(R.id.card_rich_text);
    view.setOnClickListener(fakeClickListener);
  }

  private View.OnClickListener fakeClickListener = new View.OnClickListener() {
    @Override public void onClick(View v) {

    }
  };

  private void bindTo() {
    if (!TextUtils.isEmpty(richTextElement.getHtml())) {
      cardRichText.setText(Html.fromHtml(richTextElement.getHtml()));
    }
  }

  public void setRichTextElement(ArticleRichTextElement richTextElement) {
    this.richTextElement = richTextElement;
  }

  @Override public void initialize() {
    if (richTextElement != null) {
      bindTo();
    }
  }
}
