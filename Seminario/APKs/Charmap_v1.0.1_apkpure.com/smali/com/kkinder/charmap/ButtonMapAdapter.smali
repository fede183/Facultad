.class public Lcom/kkinder/charmap/ButtonMapAdapter;
.super Landroid/widget/BaseAdapter;
.source "ButtonMapAdapter.java"


# instance fields
.field private activity:Lcom/kkinder/charmap/Charmap;

.field private appEditArea:Landroid/view/View;

.field private appEditor:Landroid/widget/EditText;

.field private characters:[Ljava/lang/String;

.field private mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/kkinder/charmap/Charmap;Landroid/view/View;Landroid/widget/EditText;[Ljava/lang/String;)V
    .locals 1
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "a"    # Lcom/kkinder/charmap/Charmap;
    .param p3, "editArea"    # Landroid/view/View;
    .param p4, "editor"    # Landroid/widget/EditText;
    .param p5, "chars"    # [Ljava/lang/String;

    .prologue
    .line 20
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 15
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/String;

    iput-object v0, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->characters:[Ljava/lang/String;

    .line 21
    iput-object p1, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->mContext:Landroid/content/Context;

    .line 22
    iput-object p2, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->activity:Lcom/kkinder/charmap/Charmap;

    .line 23
    iput-object p5, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->characters:[Ljava/lang/String;

    .line 24
    iput-object p3, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->appEditArea:Landroid/view/View;

    .line 25
    iput-object p4, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->appEditor:Landroid/widget/EditText;

    .line 26
    return-void
.end method

.method static synthetic access$0(Lcom/kkinder/charmap/ButtonMapAdapter;)Landroid/view/View;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->appEditArea:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1(Lcom/kkinder/charmap/ButtonMapAdapter;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->appEditor:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$2(Lcom/kkinder/charmap/ButtonMapAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$3(Lcom/kkinder/charmap/ButtonMapAdapter;)Lcom/kkinder/charmap/Charmap;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->activity:Lcom/kkinder/charmap/Charmap;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->characters:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 33
    const/4 v0, 0x0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 37
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 45
    if-nez p2, :cond_0

    .line 46
    new-instance v1, Landroid/widget/Button;

    iget-object v2, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Landroid/widget/Button;-><init>(Landroid/content/Context;)V

    .line 50
    .local v1, "button":Landroid/widget/Button;
    :goto_0
    iget-object v2, p0, Lcom/kkinder/charmap/ButtonMapAdapter;->characters:[Ljava/lang/String;

    aget-object v2, v2, p1

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 52
    new-instance v2, Lcom/kkinder/charmap/ButtonMapAdapter$1;

    invoke-direct {v2, p0}, Lcom/kkinder/charmap/ButtonMapAdapter$1;-><init>(Lcom/kkinder/charmap/ButtonMapAdapter;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 70
    return-object v1

    .line 48
    .end local v1    # "button":Landroid/widget/Button;
    :cond_0
    move-object v0, p2

    check-cast v0, Landroid/widget/Button;

    move-object v1, v0

    .restart local v1    # "button":Landroid/widget/Button;
    goto :goto_0
.end method
