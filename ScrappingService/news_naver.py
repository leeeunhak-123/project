import csv
import urllib.request
import json
from datetime import datetime, timedelta, timezone

client_id = "Imw1dmtm0oUHtXZoMxzn"
client_secret = "ytAf4ZBmzJ"

def make_url(sNode, search_text, start):
    base = "https://openapi.naver.com/v1/search"
    node = "/%s.json" % sNode
    query = urllib.parse.quote(search_text)
    parameters = f"?query={query}&start={start}&display=100"
    return f"{base}{node}{parameters}"

def request_url(url):
    req = urllib.request.Request(url)
    req.add_header("X-Naver-Client-Id", client_id)
    req.add_header("X-Naver-Client-Secret", client_secret)
    try:
        with urllib.request.urlopen(req) as response:
            if response.status == 200:
                print("Url Request Success")
                return response.read().decode('utf-8')
    except Exception as e:
        print(e)
        print("Error for URL:", url)
        return None

def crawl_news(sNode, search_text, start_date, end_date):
    all_news = []
    current_date = start_date.replace(tzinfo=timezone.utc)  # Make current_date aware
    while current_date <= end_date:
        target_url = make_url(sNode, search_text, 1)  # Start from the first page
        while target_url:
            result = request_url(target_url)
            if result:
                news_dict = json.loads(result)
                items = news_dict.get('items', [])
                if not items:
                    break
                for news in items:
                    news_date = datetime.strptime(news['pubDate'], '%a, %d %b %Y %H:%M:%S %z')
                    if news_date > end_date:
                        break  # Exit the loop if news date exceeds end date
                    if news_date >= current_date:
                        all_news.append(news)
                    else:
                        return all_news  # No need to crawl older news
                start = int(news_dict.get('start', 1))
                target_url = make_url(sNode, search_text, start + len(items))
            else:
                break
        current_date += timedelta(days=1)  # Move to the next day
    return all_news

def write_to_csv(news_list, csv_filename):
    with open(csv_filename, 'w', newline='', encoding='utf-8-sig') as csvfile:
        fieldnames = ['Title', 'Link', 'Content', 'Date']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()
        for news in news_list:
            writer.writerow({
                'Title': news['title'],
                'Link': news['link'],
                'Content': news['description'],
                'Date': news['pubDate']
            })


def main():
    sNode = 'news'
    search_text = "서울 출산 정책"
    start_date = datetime(2024, 1, 1)
    end_date = datetime.now(timezone.utc)

    news_list = crawl_news(sNode, search_text, start_date, end_date)

    # Process the crawled news articles
    for idx, news in enumerate(news_list, 1):
        print(f"{idx}. Title: {news['title']}")
        print(f"   Link: {news['link']}")
        print(f"   Content: {news['description']}\n")
        print(f"   Date: {news['pubDate']}")

    # Write the news data to a CSV file
    csv_filename = 'crawled_news.csv'
    write_to_csv(news_list, csv_filename)
    print(f"\nCrawled news data has been written to '{csv_filename}'.")

if __name__ == "__main__":
    main()

                                                                                                                                                                                      