.class Lcom/kkinder/charmap/Charmap$2;
.super Ljava/lang/Object;
.source "Charmap.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/kkinder/charmap/Charmap;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/kkinder/charmap/Charmap;


# direct methods
.method constructor <init>(Lcom/kkinder/charmap/Charmap;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/kkinder/charmap/Charmap$2;->this$0:Lcom/kkinder/charmap/Charmap;

    .line 136
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 139
    iget-object v6, p0, Lcom/kkinder/charmap/Charmap$2;->this$0:Lcom/kkinder/charmap/Charmap;

    const v7, 0x7f060007

    invoke-virtual {v6, v7}, Lcom/kkinder/charmap/Charmap;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    .line 140
    .local v3, "editor":Landroid/widget/EditText;
    iget-object v6, p0, Lcom/kkinder/charmap/Charmap$2;->this$0:Lcom/kkinder/charmap/Charmap;

    invoke-virtual {v6}, Lcom/kkinder/charmap/Charmap;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 141
    .local v1, "c":Landroid/content/Context;
    const-string v6, "clipboard"

    invoke-virtual {v1, v6}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/text/ClipboardManager;

    .line 142
    .local v0, "ClipMan":Landroid/text/ClipboardManager;
    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v0, v6}, Landroid/text/ClipboardManager;->setText(Ljava/lang/CharSequence;)V

    .line 144
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "\""

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\" copied to clipboard."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 145
    .local v4, "text":Ljava/lang/CharSequence;
    const/4 v2, 0x0

    .line 147
    .local v2, "duration":I
    invoke-static {v1, v4, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v5

    .line 148
    .local v5, "toast":Landroid/widget/Toast;
    invoke-virtual {v5}, Landroid/widget/Toast;->show()V

    .line 149
    iget-object v6, p0, Lcom/kkinder/charmap/Charmap$2;->this$0:Lcom/kkinder/charmap/Charmap;

    invoke-virtual {v6}, Lcom/kkinder/charmap/Charmap;->finish()V

    .line 150
    return-void
.end method
