.class Lcom/kkinder/charmap/ButtonMapAdapter$1;
.super Ljava/lang/Object;
.source "ButtonMapAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/kkinder/charmap/ButtonMapAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/kkinder/charmap/ButtonMapAdapter;


# direct methods
.method constructor <init>(Lcom/kkinder/charmap/ButtonMapAdapter;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/kkinder/charmap/ButtonMapAdapter$1;->this$0:Lcom/kkinder/charmap/ButtonMapAdapter;

    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 55
    iget-object v5, p0, Lcom/kkinder/charmap/ButtonMapAdapter$1;->this$0:Lcom/kkinder/charmap/ButtonMapAdapter;

    # getter for: Lcom/kkinder/charmap/ButtonMapAdapter;->appEditArea:Landroid/view/View;
    invoke-static {v5}, Lcom/kkinder/charmap/ButtonMapAdapter;->access$0(Lcom/kkinder/charmap/ButtonMapAdapter;)Landroid/view/View;

    move-result-object v5

    invoke-virtual {v5}, Landroid/view/View;->getVisibility()I

    move-result v5

    if-nez v5, :cond_0

    .line 56
    iget-object v5, p0, Lcom/kkinder/charmap/ButtonMapAdapter$1;->this$0:Lcom/kkinder/charmap/ButtonMapAdapter;

    # getter for: Lcom/kkinder/charmap/ButtonMapAdapter;->appEditor:Landroid/widget/EditText;
    invoke-static {v5}, Lcom/kkinder/charmap/ButtonMapAdapter;->access$1(Lcom/kkinder/charmap/ButtonMapAdapter;)Landroid/widget/EditText;

    move-result-object v5

    check-cast p1, Landroid/widget/Button;

    .end local p1    # "v":Landroid/view/View;
    invoke-virtual {p1}, Landroid/widget/Button;->getText()Ljava/lang/CharSequence;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/EditText;->append(Ljava/lang/CharSequence;)V

    .line 68
    :goto_0
    return-void

    .line 58
    .restart local p1    # "v":Landroid/view/View;
    :cond_0
    iget-object v5, p0, Lcom/kkinder/charmap/ButtonMapAdapter$1;->this$0:Lcom/kkinder/charmap/ButtonMapAdapter;

    # getter for: Lcom/kkinder/charmap/ButtonMapAdapter;->mContext:Landroid/content/Context;
    invoke-static {v5}, Lcom/kkinder/charmap/ButtonMapAdapter;->access$2(Lcom/kkinder/charmap/ButtonMapAdapter;)Landroid/content/Context;

    move-result-object v5

    const-string v6, "clipboard"

    invoke-virtual {v5, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/text/ClipboardManager;

    .line 59
    .local v1, "ClipMan":Landroid/text/ClipboardManager;
    move-object v0, p1

    check-cast v0, Landroid/widget/Button;

    move-object v5, v0

    invoke-virtual {v5}, Landroid/widget/Button;->getText()Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v1, v5}, Landroid/text/ClipboardManager;->setText(Ljava/lang/CharSequence;)V

    .line 61
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "\""

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    check-cast p1, Landroid/widget/Button;

    .end local p1    # "v":Landroid/view/View;
    invoke-virtual {p1}, Landroid/widget/Button;->getText()Ljava/lang/CharSequence;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\" copied to clipboard."

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 62
    .local v3, "text":Ljava/lang/CharSequence;
    const/4 v2, 0x0

    .line 64
    .local v2, "duration":I
    iget-object v5, p0, Lcom/kkinder/charmap/ButtonMapAdapter$1;->this$0:Lcom/kkinder/charmap/ButtonMapAdapter;

    # getter for: Lcom/kkinder/charmap/ButtonMapAdapter;->mContext:Landroid/content/Context;
    invoke-static {v5}, Lcom/kkinder/charmap/ButtonMapAdapter;->access$2(Lcom/kkinder/charmap/ButtonMapAdapter;)Landroid/content/Context;

    move-result-object v5

    invoke-static {v5, v3, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v4

    .line 65
    .local v4, "toast":Landroid/widget/Toast;
    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    .line 66
    iget-object v5, p0, Lcom/kkinder/charmap/ButtonMapAdapter$1;->this$0:Lcom/kkinder/charmap/ButtonMapAdapter;

    # getter for: Lcom/kkinder/charmap/ButtonMapAdapter;->activity:Lcom/kkinder/charmap/Charmap;
    invoke-static {v5}, Lcom/kkinder/charmap/ButtonMapAdapter;->access$3(Lcom/kkinder/charmap/ButtonMapAdapter;)Lcom/kkinder/charmap/Charmap;

    move-result-object v5

    invoke-virtual {v5}, Lcom/kkinder/charmap/Charmap;->finish()V

    goto :goto_0
.end method
